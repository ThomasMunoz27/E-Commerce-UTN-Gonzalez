package com.ecommerce.ecommerce.Controllers;


import com.ecommerce.ecommerce.MpDTO.CartItemDTO;

import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.net.MPResponse;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/payments")
public class MercadoPagoController {

    @Value("${MERCADOPAGO_ACCESS_TOKEN}")
    private String accesToken;

    @PostMapping("/create-preference")
    public ResponseEntity<String> createCheckout(@RequestBody List<CartItemDTO> cartItems){
        try{
            com.mercadopago.MercadoPagoConfig.setAccessToken(accesToken);
            System.out.println("Token Mercado Pago: " + accesToken);

            PreferenceBackUrlsRequest backUrls =

                    PreferenceBackUrlsRequest.builder()
                            .success("https://localhost:5173/success")
                            .pending("https://www.seu-site/pending")
                            .failure("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley")
                            .build();



            PreferencePayerRequest payer = PreferencePayerRequest.builder()
                    .email("test_user_169965231@testuser.com")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();

            for (CartItemDTO cartItem : cartItems){
                System.out.println("Procesando producto: " + cartItem.getName());
                PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                        .id(String.valueOf(cartItem.getId()))
                        .title(cartItem.getName())
                        .pictureUrl(cartItem.getImageUrl())
                        .quantity(cartItem.getQuantity())
                        .unitPrice(BigDecimal.valueOf(cartItem.getPrice()).setScale(2, RoundingMode.HALF_UP))
                        .categoryId(cartItem.getCategory()) // comentá esta línea por ahora
                        .currencyId("ARS")
                        .build();
                items.add(itemRequest);
            }

            List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
            excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("ticket").build());

            PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                    .excludedPaymentTypes(excludedPaymentTypes)
                    .installments(1)
                    .build();

            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    //.payer(payer)
                    .backUrls(backUrls)
                    .paymentMethods(paymentMethods)
                    .autoReturn("approved")
                    .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);


            String prefId = preference.getId();

            System.out.println("URL de pago: " + preference.getInitPoint());

            return ResponseEntity.status(HttpStatus.OK).body("{\"preferenceId\":\""+prefId+"\"}");



            //return ResponseEntity.ok(preference.getSandboxInitPoint());
        }catch (MPApiException mpEx){

            MPResponse response = mpEx.getApiResponse();
            System.err.println("Status code: " + response.getStatusCode());
            System.err.println("Response body: " + response.getContent());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la preferencia: " + response.getContent());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + e.getMessage());
        }
    }
}

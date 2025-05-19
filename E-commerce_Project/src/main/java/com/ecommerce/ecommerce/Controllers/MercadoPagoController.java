package com.ecommerce.ecommerce.Controllers;


import com.ecommerce.ecommerce.MpDTO.CartItemDTO;

import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.net.MPResponse;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class MercadoPagoController {

    @Value("${MERCADOPAGO_ACCESS_TOKEN}")
    private String accesToken;

    @PostMapping("/create-preference")
    public ResponseEntity<String> createCheckout(@RequestBody List<CartItemDTO> cartItems){
        try{
            com.mercadopago.MercadoPagoConfig.setAccessToken(accesToken);
            System.out.println("Token Mercado Pago: " + accesToken);

            PreferencePayerRequest payer = PreferencePayerRequest.builder()
                    .email("test_user_169965231@testuser.com")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();

            for (CartItemDTO cartItem : cartItems){
                System.out.println("Procesando producto: " + cartItem.getName());
                PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                        .title(cartItem.getName())
                        .pictureUrl(cartItem.getImageUrl())
                        .quantity(cartItem.getQuantity())
                        .unitPrice(BigDecimal.valueOf(cartItem.getPrice()).setScale(2, RoundingMode.HALF_UP))
                        //.categoryId(cartItem.getCategory()) // comentá esta línea por ahora
                        .currencyId("ARS")
                        .build();
                items.add(itemRequest);
            }

            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .payer(payer)
                    .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            System.out.println("URL de pago: " + preference.getInitPoint());

            return ResponseEntity.ok(preference.getInitPoint());
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

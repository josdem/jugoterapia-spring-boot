/*
Copyright 2017 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.jos.dem.jugoterapia.validator

import org.springframework.stereotype.Component

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier

@Component
class TokenValidator {

  void validate(String token){
    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
      .setAudience(Collections.singletonList(CLIENT_ID))
      .build();

    GoogleIdToken idToken = verifier.verify(token)
    if (idToken != null) {
      Payload payload = idToken.getPayload();
      String userId = payload.getSubject();
      log.info "User ID: $userId"
      String email = payload.getEmail();
      boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
      String name = (String) payload.get("name");
      String pictureUrl = (String) payload.get("picture");
      String locale = (String) payload.get("locale");
      String familyName = (String) payload.get("family_name");
      String givenName = (String) payload.get("given_name");
    } else {
      log.info "Invalid token"
    }
  }

}

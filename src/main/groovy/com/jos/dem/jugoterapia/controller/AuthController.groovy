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

package com.jos.dem.jugoterapia.controller

import static org.springframework.web.bind.annotation.RequestMethod.POST

import javax.validation.Valid
import javax.servlet.http.HttpServletResponse

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.jugoterapia.command.AuthCommand
import com.jos.dem.jugoterapia.service.AuthService
import com.jos.dem.jugoterapia.validator.AuthValidator
import com.jos.dem.jugoterapia.validator.TokenValidator

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/auth")
class AuthController {

  @Autowired
  AuthValidator authValidator
  @Autowired
  TokenValidator tokenValidator
  @Autowired
  AuthService authService

  Logger log = LoggerFactory.getLogger(this.class)

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.addValidators(authValidator)
  }

  @RequestMapping(method = POST, value = "/validate", consumes="application/json")
  ResponseEntity<String> message(@Valid @RequestBody AuthCommand command) {
    log.info "Authorization requested: ${command.dump()}"
    tokenValidator.validate(command.token)
    authService.save(command)
    new ResponseEntity<String>("OK", HttpStatus.OK)
  }

  @ExceptionHandler(Exception.class)
  void handleException(HttpServletResponse response, Exception exception){
    println exception.printStackTrace()
    log.info "Exception: $exception.message"
    response.status = HttpServletResponse.SC_UNAUTHORIZED
    response.writer.print('Unauthorized')
  }

}

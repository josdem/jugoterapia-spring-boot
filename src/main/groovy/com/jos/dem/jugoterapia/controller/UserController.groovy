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

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

import com.jos.dem.jugoterapia.command.AuthCommand

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/user")
class UserController {


  @RequestMapping(method = POST, value = "/log", consumes="application/json")
  ResponseEntity<String> message(@RequestBody AuthCommand command) {
    new ResponseEntity<String>("OK", HttpStatus.OK)
  }

}
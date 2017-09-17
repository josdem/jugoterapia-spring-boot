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

package com.jos.dem.jugoterapia.service.impl

import groovyx.net.http.RESTClient

import org.springframework.stereotype.Service

import com.jos.dem.jugoterapia.service.RestClient
import com.jos.dem.jugoterapia.exception.BusinessException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class RestClientImpl implements RestClient {

  Logger log = LoggerFactory.getLogger(this.class)

  def getData(String token){
    try {
      log.info "Calling Service"
      RESTClient restClient = new RESTClient()
      def result = restClient.get(
        uri : "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=${token}"
      )
      result.data
    } catch(Exception ex) {
      log.warn "Error ${ex.message}"
      throw new BusinessException(ex.message)
    }
  }

}


/*
  Copyright 2018 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
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

package com.jos.dem.jugoterapia

import com.jos.dem.jugoterapia.model.AuthLog
import com.jos.dem.jugoterapia.command.Command
import com.jos.dem.jugoterapia.command.AuthCommand
import com.jos.dem.jugoterapia.service.AuthService
import com.jos.dem.jugoterapia.service.impl.AuthServiceImpl
import com.jos.dem.jugoterapia.repository.AuthRepository

import spock.lang.Specification

class AuthServiceSpec extends Specification {

  AuthService service = new AuthServiceImpl()

  AuthRepository authRepository = Mock(AuthRepository)

  def setup(){
    service.authRepository = authRepository
  }

  void "should save auth command"(){
    given:'And auth command'
      Command command = new AuthCommand(
        name:'josdem',
        email: 'joseluis.delacruz@gmail.com',
        picture: 'happy_face'
      )
    when:'We save'
      AuthLog result = service.save(command)
    then:'We expect command saved'
      result.name == 'josdem'
      result.email == 'joseluis.delacruz@gmail.com'
      result.picture == 'happy_face'
      result.dateCreated != null
      1 * authRepository.save(_ as AuthLog)
  }

}

/*
    Copyright 2019 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
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
package com.ericsson.eiffel.remrem.publish.exception;

import com.ericsson.eiffel.remrem.publish.helper.RMQBeanConnectionFactory;

public class RemRemPublishException extends Exception {

    private static final long serialVersionUID = 1L;

    public RemRemPublishException(String message) {
        super(message);
    }

    public RemRemPublishException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemRemPublishException(String message, RMQBeanConnectionFactory factory,
            Throwable cause) {
        super(message + factory.getHost() + ":" + factory.getPort(), cause);
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        Throwable cause = getCause();
        if (cause != null) {
            message += "; root cause: '" + cause.getMessage() + "'";
        }

        return message;
    }
}

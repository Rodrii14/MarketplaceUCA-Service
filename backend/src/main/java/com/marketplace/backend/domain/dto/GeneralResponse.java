package com.marketplace.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class GeneralResponse {

    private Object data;
    private String message;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object data;
        private String message;
        private HttpStatus status;

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ResponseEntity<GeneralResponse> build() {
            if(this.message == null){
                this.message = this.status.getReasonPhrase();
            }

            return new ResponseEntity<>(new GeneralResponse(this.data, this.message), this.status);
        }
    }
}

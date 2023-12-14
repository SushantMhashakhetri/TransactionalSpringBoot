# TransactionalSpringBoot
POST: http://localhost:8080/api/v1/order
{
    "order": {
        "totalQuantity": 2,
        "totalPrice": 222,
        "status": "SUCCESSFUL"
    },
    "payment":{
        "type":"DEBIT",
        "cardName":"SUSHANT MHASHAKHETRI",
        "cardNumber":"123 123",
        "expiryYear":2025,
        "expiryMonth":12,
        "cvc":123


    }

}

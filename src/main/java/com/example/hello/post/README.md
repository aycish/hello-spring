## POST API

---

### [JSON]

- client에서 보내주는 형태로 생각하자
- 기본적인 형태
```
{
    "key" : "value"
    string  : value
    number  : value
    boolean : value
    object  : value
    array   : value
    ...
    
    "phone_number" : "value", // snake case
    "phoneNumber"  : "value"  // camel case
}
```
- object의 경우, {}로 묶인다.
- array의 경우, []로 묶인다.
- snakecase를 종종 사용하므로 유의한다.
- 예시

```
    "phone_number" : "010-1234-5678",
    "age" : 10,
    "isAgree" : false,
    "account" : {
        "email" : "abc@gmail.com",
        "password" : "1234"
    },
    "user_list" : [
        {
            "account" : "abcd",
            "password" : "1234"
        },
        {
            "account" : "aaaa",
            "password" : "bbbb"
        },
        {
            "account" : "bbbb",
            "password" : "cccc"
        },
    ]
```

### [DTO]

- Dto의 필드들은 JSON의 키 값과 동일해야한다.
- JSON의 경우 SnakeCase를, JAVA의 경우는 Camel을 많이 사용하는데, 이때는 @JsonPropoerty 어노테이션을 통해 어느정도 맵핑시켜줄 수 있다.

### [관련 Annotation]

- @PostMapping : Post Resource 설정
- @RequestBody : Request Body 부분 Parsing
- @PathVariable : URL Path Variable Parsing -> Get과 동일하게 동작
- @JsonProperty : Json naming
- @JsonNaming : class json naming
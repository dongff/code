package cn.com.sign;

import org.springframework.web.bind.annotation.*;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-07-18 15:32
 * @modified By:
 */
@RestController
@RequestMapping("user")
public class SignTestController {

    @Signature
    @GetMapping("test/{id}")
    public ResponseResult<String> myController(@PathVariable String id
            , @RequestParam String client
            , @RequestBody User user) {
        return ResponseResult.success(String.join(",", id, client, user.toString()));
    }
}

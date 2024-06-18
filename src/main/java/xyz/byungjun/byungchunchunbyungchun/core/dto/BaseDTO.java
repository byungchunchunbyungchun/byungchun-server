package xyz.byungjun.byungchunchunbyungchun.core.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseDTO <T> {
    private int status;
    private T data;
}

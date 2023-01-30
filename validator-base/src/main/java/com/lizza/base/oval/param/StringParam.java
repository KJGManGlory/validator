package com.lizza.base.oval.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StringParam {

    @NotEmpty
    private String id;

    @NotNull
    private String name;

    @NotBlank
    private String desc;

    @NotBlank
    private String job;

    @Length(min = 1, max = 3)
    private String info;
}

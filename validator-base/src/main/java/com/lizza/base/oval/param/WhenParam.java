package com.lizza.base.oval.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WhenParam {

    @NotNull
    String sex;

    @NotEmpty(when = "groovy:_this.sex == '1'")
    @NotNull(when = "groovy:_this.sex == '1'")
    String man;

    @NotEmpty(when = "groovy:_this.sex == '0'")
    @NotNull(when = "groovy:_this.sex == '0'")
    String woman;
}

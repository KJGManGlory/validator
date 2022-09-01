package com.lizza.base.oval;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListParam {

    @NotNull
    private List<String> ids;

    @Size(min = 1, max = 3)
    private List<String> phones;
}

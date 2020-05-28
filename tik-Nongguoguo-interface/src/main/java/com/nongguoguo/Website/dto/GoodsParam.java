package com.nongguoguo.Website.dto;

import com.nongguoguo.Website.domain.Category;
import com.nongguoguo.Website.domain.Pics;
import lombok.Data;
import java.util.List;

/**
 *
 */
@Data
public class GoodsParam {

    private List<Pics> pics;
    private Category category;

}

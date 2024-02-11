package com.magic4.magicard.dto_sy;

import com.magic4.magicard.vo.PurposeCategory;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurposeItemDto {
    private UUID purposeItemUid;
    private PurposeCategory purposeCategory;
    private String purposeItem;
}

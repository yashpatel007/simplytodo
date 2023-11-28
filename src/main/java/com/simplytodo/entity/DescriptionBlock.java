package com.simplytodo.entity;

import com.simplytodo.enums.DescriptionBlockType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.UUID;

@Document(collection = "description_block")
@Data
public class DescriptionBlock {

    @Id
    private String id = UUID.randomUUID().toString();
    private DescriptionBlockType blockType;
    private String content;

    List<DescriptionBlock> childBlocks;

    public void setBlockType(DescriptionBlockType blockType) {
        this.blockType = blockType;
    }

    public void setContent(String content) {
        if(this.blockType == null)
            throw new IllegalStateException("Block type must be set before setting content");
        this.content = content;
    }

    public void setChildBlocks(List<DescriptionBlock> childBlocks) {
        if(this.blockType == null)
            throw new IllegalStateException("Block type must be set before setting child blocks");
        if(this.blockType == DescriptionBlockType.IMAGE)
            throw new IllegalStateException("image block cannot have child blocks");
        this.childBlocks = childBlocks;
    }

    public void addBlock(DescriptionBlockType blockType, String content) {
        if(this.blockType == null)
            throw new IllegalStateException("Block type must be set before adding child blocks");
        DescriptionBlock block = new DescriptionBlock();
        block.setBlockType(blockType);
        block.setContent(content);
        this.childBlocks.add(block);
    }
}

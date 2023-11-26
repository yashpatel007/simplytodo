package com.simplytodo.entity;

import com.simplytodo.enums.DescriptionBlockType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DescriptionBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DescriptionBlockType blockType;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_id")
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
        this.childBlocks.add(DescriptionBlock.builder().blockType(blockType).content(content).build());
    }
}

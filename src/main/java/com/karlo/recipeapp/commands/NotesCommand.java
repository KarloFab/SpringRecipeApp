package com.karlo.recipeapp.commands;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String recipeNotes;
}

package br.com.vithorfjm.projectmanagement.entities.task;

public record TaskDTO (Long id,
                       String title,
                       String description,
                       String estimatedTerm,
                       String status,
                       Long user_id)  {
}

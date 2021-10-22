package co.edu.unbosque.model.dto;

//Parametros de la tabla CasoMascota.

public final class CasoMascota {
    private final String created_at, type, description;
    private final int pet_id;

    public CasoMascota(String created_at, String type, String description, int pet_id) {
        this.description = description;
        this.pet_id = pet_id;
        this.created_at = created_at;
        this.type = type;
    }
    public String getDescription() {
        return description;
    }

    public int getPet_id() {
        return pet_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getType() {
        return type;
    }


}

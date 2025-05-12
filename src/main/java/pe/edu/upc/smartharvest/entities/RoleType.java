package pe.edu.upc.smartharvest.entities;

public enum RoleType {
    ADMIN,
    AGRICULTOR,
    DUEÑO_DE_MERCADO;

    // Opcional: Metodo para verificar si un String es un RoleType válido
    public static boolean isValid(String role) {
        try {
            RoleType.valueOf(role.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

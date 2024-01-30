package lt.daujotas.mapper;

public interface Mapper<E, DTO> {
    DTO toDto(E entity);
    E fromDto(DTO dto);
}

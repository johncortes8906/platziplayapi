package com.platzi.platziplayapi.persistence.mapper;

import com.platzi.platziplayapi.domain.dto.MovieDto;
import com.platzi.platziplayapi.domain.dto.MovieUpdateRequestDto;
import com.platzi.platziplayapi.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {

    @Mapping(target = "genre", qualifiedByName = "stringToGenre")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);
    @InheritInverseConfiguration
    @Mapping(target = "genre", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto movieDto);
    @Mapping(target = "title")
    @Mapping(target = "releaseDate")
    @Mapping(target = "rating")
    void updateEntityFromDto(MovieUpdateRequestDto movieUpdateRequestDto, @MappingTarget MovieEntity movieEntity);
}

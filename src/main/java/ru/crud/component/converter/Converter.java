package ru.crud.component.converter;

public interface Converter <FROM, TO> {

  TO convert(FROM from);
}

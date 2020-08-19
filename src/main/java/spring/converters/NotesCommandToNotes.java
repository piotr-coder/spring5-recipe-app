package spring.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.commands.NotesCommand;
import spring.domain.Notes;

/**
 * Created by Piotr on 2020-08-18
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }
        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}

package corso.java.translations.controllers.api.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
	private String messageCode;
	private final List<TranslationModel> translations = new ArrayList<>();
}

package com.springsecret;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

/**
 * DatePropertyEditorRegistrar
 *
 * @author Alphonse
 * @version 1.0
 * @date 2021/2/26 09:07
 **/
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {

    private PropertyEditor propertyEditor;

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(java.util.Date.class, propertyEditor);
    }

    public PropertyEditor getPropertyEditor() {
        return new DatePropertyEditor();
    }
}

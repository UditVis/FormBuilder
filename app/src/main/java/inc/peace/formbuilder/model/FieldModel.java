package inc.peace.formbuilder.model;

import org.json.JSONObject;

/**
 * Created by Udit on 2/1/2018.
 */

public class FieldModel {
    private String formID;
    private String fieldID;
    private String fieldName;
    private String fieldReference;
    private String fieldQuestion;
    private String fieldType;
    private JSONObject fieldProperties;
    private boolean isRequired;

    public String getFormID() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    public String getFieldID() {
        return fieldID;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldReference() {
        return fieldReference;
    }

    public void setFieldReference(String fieldReference) {
        this.fieldReference = fieldReference;
    }

    public String getFieldQuestion() {
        return fieldQuestion;
    }

    public void setFieldQuestion(String fieldQuestion) {
        this.fieldQuestion = fieldQuestion;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public JSONObject getFieldProperties() {
        return fieldProperties;
    }

    public void setFieldProperties(JSONObject fieldProperties) {
        this.fieldProperties = fieldProperties;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }
}

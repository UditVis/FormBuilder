package inc.peace.formbuilder.model;

import java.util.List;

/**
 * Created by Udit on 2/8/2018.
 */

public class FormModel {
    private  String formUID;
    private String formName;
    private List<String> subformId;
    private List<FieldModel> formFields;
    private String fieldsId;
    private String ownerId;

    public int getNoOfFields() {
        return noOfFields;
    }

    public void setNoOfFields(int noOfFields) {
        this.noOfFields = noOfFields;
    }

    private int noOfFields = 0;

    public String getFormUID() {
        return formUID;
    }

    public void setFormUID(String formUID) {
        this.formUID = formUID;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<String> getSubformId() {
        return subformId;
    }

    public void setSubformId(List<String> subformId) {
        this.subformId = subformId;
    }

    public List<FieldModel> getFormFields() {
        return formFields;
    }

    public void setFormFields(List<FieldModel> formFields) {
        this.formFields = formFields;
    }

    public String getFieldsId() {
        return fieldsId;
    }

    public void setFieldsId(String fieldsId) {
        this.fieldsId = fieldsId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}

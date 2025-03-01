
/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 5.16.0
 */

package sap.example.odata.generate.namespaces.odata;

import java.math.BigDecimal;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Maps;
import com.google.gson.annotations.JsonAdapter;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataEntityKey;
import com.sap.cloud.sdk.datamodel.odatav4.core.SimpleProperty;
import com.sap.cloud.sdk.datamodel.odatav4.core.VdmEntity;
import com.sap.cloud.sdk.datamodel.odatav4.core.VdmEntitySet;
import com.sap.cloud.sdk.result.ElementName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sap.example.odata.generate.services.OdataService;


/**
 * <p>Original entity name from the Odata EDM: <b>Sales_by_Category</b></p>
 * 
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true, callSuper = true)
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@JsonAdapter(com.sap.cloud.sdk.datamodel.odatav4.adapter.GsonVdmAdapterFactory.class)
@JsonSerialize(using = com.sap.cloud.sdk.datamodel.odatav4.adapter.JacksonVdmObjectSerializer.class)
@JsonDeserialize(using = com.sap.cloud.sdk.datamodel.odatav4.adapter.JacksonVdmObjectDeserializer.class)
public class Sales_by_Category
    extends VdmEntity<Sales_by_Category>
    implements VdmEntitySet
{

    @Getter
    private final java.lang.String odataType = "NorthwindModel.Sales_by_Category";
    /**
     * Selector for all available fields of Sales_by_Category.
     * 
     */
    public final static SimpleProperty<Sales_by_Category> ALL_FIELDS = all();
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>CategoryID</b></p>
     * 
     * @return
     *     The categoryID contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("CategoryID")
    private Integer categoryID;
    public final static SimpleProperty.NumericInteger<Sales_by_Category> CATEGORY_ID = new SimpleProperty.NumericInteger<Sales_by_Category>(Sales_by_Category.class, "CategoryID");
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>CategoryName</b></p>
     * 
     * @return
     *     The categoryName contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("CategoryName")
    private java.lang.String categoryName;
    public final static SimpleProperty.String<Sales_by_Category> CATEGORY_NAME = new SimpleProperty.String<Sales_by_Category>(Sales_by_Category.class, "CategoryName");
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductName</b></p>
     * 
     * @return
     *     The productName contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("ProductName")
    private java.lang.String productName;
    public final static SimpleProperty.String<Sales_by_Category> PRODUCT_NAME = new SimpleProperty.String<Sales_by_Category>(Sales_by_Category.class, "ProductName");
    /**
     * Constraints: Nullable<p>Original property name from the Odata EDM: <b>ProductSales</b></p>
     * 
     * @return
     *     The productSales contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("ProductSales")
    private BigDecimal productSales;
    public final static SimpleProperty.NumericDecimal<Sales_by_Category> PRODUCT_SALES = new SimpleProperty.NumericDecimal<Sales_by_Category>(Sales_by_Category.class, "ProductSales");

    @Nonnull
    @Override
    public Class<Sales_by_Category> getType() {
        return Sales_by_Category.class;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>CategoryID</b></p>
     * 
     * @param categoryID
     *     The categoryID to set.
     */
    public void setCategoryID(
        @Nullable
        final Integer categoryID) {
        rememberChangedField("CategoryID", this.categoryID);
        this.categoryID = categoryID;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>CategoryName</b></p>
     * 
     * @param categoryName
     *     The categoryName to set.
     */
    public void setCategoryName(
        @Nullable
        final java.lang.String categoryName) {
        rememberChangedField("CategoryName", this.categoryName);
        this.categoryName = categoryName;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductName</b></p>
     * 
     * @param productName
     *     The productName to set.
     */
    public void setProductName(
        @Nullable
        final java.lang.String productName) {
        rememberChangedField("ProductName", this.productName);
        this.productName = productName;
    }

    /**
     * Constraints: Nullable<p>Original property name from the Odata EDM: <b>ProductSales</b></p>
     * 
     * @param productSales
     *     The productSales to set.
     */
    public void setProductSales(
        @Nullable
        final BigDecimal productSales) {
        rememberChangedField("ProductSales", this.productSales);
        this.productSales = productSales;
    }

    @Override
    protected java.lang.String getEntityCollection() {
        return "Sales_by_Categories";
    }

    @Nonnull
    @Override
    protected ODataEntityKey getKey() {
        final ODataEntityKey entityKey = super.getKey();
        entityKey.addKeyProperty("CategoryID", getCategoryID());
        entityKey.addKeyProperty("CategoryName", getCategoryName());
        entityKey.addKeyProperty("ProductName", getProductName());
        return entityKey;
    }

    @Nonnull
    @Override
    protected Map<java.lang.String, Object> toMapOfFields() {
        final Map<java.lang.String, Object> cloudSdkValues = super.toMapOfFields();
        cloudSdkValues.put("CategoryID", getCategoryID());
        cloudSdkValues.put("CategoryName", getCategoryName());
        cloudSdkValues.put("ProductName", getProductName());
        cloudSdkValues.put("ProductSales", getProductSales());
        return cloudSdkValues;
    }

    @Override
    protected void fromMap(final Map<java.lang.String, Object> inputValues) {
        final Map<java.lang.String, Object> cloudSdkValues = Maps.newLinkedHashMap(inputValues);
        // simple properties
        {
            if (cloudSdkValues.containsKey("CategoryID")) {
                final Object value = cloudSdkValues.remove("CategoryID");
                if ((value == null)||(!value.equals(getCategoryID()))) {
                    setCategoryID(((Integer) value));
                }
            }
            if (cloudSdkValues.containsKey("CategoryName")) {
                final Object value = cloudSdkValues.remove("CategoryName");
                if ((value == null)||(!value.equals(getCategoryName()))) {
                    setCategoryName(((java.lang.String) value));
                }
            }
            if (cloudSdkValues.containsKey("ProductName")) {
                final Object value = cloudSdkValues.remove("ProductName");
                if ((value == null)||(!value.equals(getProductName()))) {
                    setProductName(((java.lang.String) value));
                }
            }
            if (cloudSdkValues.containsKey("ProductSales")) {
                final Object value = cloudSdkValues.remove("ProductSales");
                if ((value == null)||(!value.equals(getProductSales()))) {
                    setProductSales(((BigDecimal) value));
                }
            }
        }
        // structured properties
        {
        }
        // navigation properties
        {
        }
        super.fromMap(cloudSdkValues);
    }

    @Override
    protected java.lang.String getDefaultServicePath() {
        return OdataService.DEFAULT_SERVICE_PATH;
    }

}

package ir.hosseinabbasi.livestyled.data.db.model


import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


@Generated("com.robohorse.robopojogenerator")
open class Dates(

	@field:SerializedName("timezone")
	open var timezone: String? = null,

	@field:SerializedName("start")
	open var start: Start? = null,

	@field:SerializedName("status")
	open var status: Status? = null,

	@field:SerializedName("spanMultipleDays")
	open var spanMultipleDays: Boolean? = null
) : RealmObject()
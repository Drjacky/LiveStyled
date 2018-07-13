package ir.hosseinabbasi.livestyled.data.db.model


import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey

/**
 * Just this model and some other depended models have extended RealmObject.
 * TODO
 */

@Generated("com.robohorse.robopojogenerator")
open class EventsItem(

	@field:SerializedName("images")
	open var images: RealmList<ImagesItem?>? = null,

	@field:SerializedName("test")
	open var test: Boolean? = null,

	@Ignore
	@field:SerializedName("seatmap")
	open var seatmap: Seatmap? = null,

	@Ignore
	@field:SerializedName("_links")
	open var links: Links? = null,

	@field:SerializedName("dates")
	open var dates: Dates? = null,

	@field:SerializedName("type")
	open var type: String? = null,

	@field:SerializedName("locale")
	open var locale: String? = null,

	@field:SerializedName("url")
	open var url: String? = null,

	@Ignore
	@field:SerializedName("sales")
	open var sales: Sales? = null,

	@Ignore
	@field:SerializedName("classifications")
	open var classifications: RealmList<ClassificationsItem?>? = null,

	@Ignore
	@field:SerializedName("_embedded")
	open var embedded: Embedded? = null,

	@field:SerializedName("name")
	open var name: String? = null,

	@field:SerializedName("pleaseNote")
	open var pleaseNote: String? = null,

	@Ignore
	@field:SerializedName("promoter")
	open var promoter: Promoter? = null,

	@PrimaryKey
	@field:SerializedName("id")
	open var id: String? = null,

	@Ignore
	@field:SerializedName("promoters")
	open var promoters: RealmList<PromotersItem?>? = null,

	@field:SerializedName("info")
	open var info: String? = null,

	open var isFav: Boolean = false
) : RealmObject() {
    // The Kotlin compiler generates standard getters and setters.
    // Realm will overload them and code inside them is ignored.
    // So if you prefer you can also just have empty abstract methods.
}
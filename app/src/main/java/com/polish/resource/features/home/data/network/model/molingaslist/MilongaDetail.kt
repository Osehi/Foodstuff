package com.polish.resource.features.home.data.network.model.molingaslist

data class MilongaDetail(
    val distance: String?,
    val email: String?,
    val facebook_link: String?,
    val instagram_link: String?,
    val is_favourite: Int?,
    val is_review: Int?,
    val lati: String?,
    val longi: String?,
    val milonga_address: String?,
    val milonga_close_time: String?,
    val milonga_days: List<MilongaDay?>?,
    val milonga_description: String?,
    val milonga_id: Int?,
    val milonga_images: List<MilongaImage?>?,
    val milonga_lesson_end: String?,
    val milonga_lesson_start: String?,
    val milonga_name: String?,
    val milonga_opening_time: String?,
    val milongas_rating: Int?,
    val phone_number: String?,
    val profileImage: String?,
    val reviews_total_count: Int?,
    val status: String?,
    val twitter_link: String?,
    val whatsapp_number: String?
)
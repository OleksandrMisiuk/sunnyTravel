package com.santa.techtest.query;

public class Query {
    public static final String QUERY_FOR_ORDER = "SELECT \n" +
            "  package.id as package_id,\n" +
            "  room.id as room_id,\n" +
            "  meal.id as meal_id, \n" +
            "  country.name as country_name, \n" +
            "  city.name as city_name, \n" +
            "  hotel.name as hotel_name, \n" +
            "  package.date_depart, \n" +
            "  package.duration, \n" +
            "  package.description as desc, \n" +
            "  room.seats, \n" +
            "  hotel.rating, \n" +
            "  room.type as room_type, \n" +
            "  hotel.sea_distance, \n" +
            "  meal.type as meal_type, \n" +
            "  package.insurance, \n" +
            "  package.visa, \n" +
            "  package.transfer\n" +
            "FROM \n" +
            "  public.\"City\" as city, \n" +
            "  public.\"Country\" as country, \n" +
            "  public.\"Hotel\" as hotel, \n" +
            "  public.\"Meal\" as meal, \n" +
            "  public.\"Package\" as package, \n" +
            "  public.\"Room\" as room\n" +
            "WHERE \n" +
            "  city.country_id = country.id AND\n" +
            "  hotel.city_id = city.id AND\n" +
            "  meal.hotel_id = hotel.id AND\n" +
            "  package.hotel_id = hotel.id AND\n" +
            "  room.hotel_id = hotel.id AND" +
            "  room.id NOT IN (SELECT room_id FROM public.\"Users_Packages\") ";

    public static final String QUERY_FOR_COUNT = "SELECT \n" +
            "  \"Package\".transfer, \n" +
            "  \"Package\".insurance, \n" +
            "  \"Country\".visafee, \n" +
            "  \"Package\".price as package_price, \n" +
            "  \"Package\".price_type as package_price_type, \n" +
            "  \"Hotel\".price_type as hotel_price_type, \n" +
            "  \"Meal\".price as meal_price, \n" +
            "  \"Room\".price as room_price, \n" +
            "  \"Room\".seats, \n" +
            "  \"Country\".price_type as country_price_type, \n" +
            "  \"Country\".eu, \n" +
            "  \"Package\".date_depart, \n" +
            "  \"Package\".duration\n" +
            "FROM \n" +
            "  public.\"City\", \n" +
            "  public.\"Country\", \n" +
            "  public.\"Hotel\", \n" +
            "  public.\"Meal\", \n" +
            "  public.\"Package\", \n" +
            "  public.\"Room\"\n" +
            "WHERE \n" +
            "  \"City\".country_id = \"Country\".id AND\n" +
            "  \"Hotel\".city_id = \"City\".id AND\n" +
            "  \"Meal\".hotel_id = \"Hotel\".id AND\n" +
            "  \"Package\".hotel_id = \"Hotel\".id AND\n" +
            "  \"Room\".hotel_id = \"Hotel\".id AND \n" +
            "  \"Package\".id = ? AND\n" +
            "  \"Room\".id = ? aND\n" +
            "  \"Meal\".id = ?;";

    public static final String QUERY_GET_CURRENCY_VALUE = "SELECT \n" +
            "  \"Currency\".value\n" +
            "FROM \n" +
            "  public.\"Currency\" \n" +
            "WHERE \"Currency\".name = ?;";

    public static final String QUERY_SET_CURRENCY_VALUE = "UPDATE " +
            "public.\"Currency\" Set value = ? WHERE \"Currency\".name = ?;";

    public static final String QUERY_GET_PACKAGE = "SELECT \n" +
            "  package.id as package_id,\n" +
            "  room.id as room_id,\n" +
            "  meal.id as meal_id, \n" +
            "  country.name as country_name, \n" +
            "  city.name as city_name, \n" +
            "  hotel.name as hotel_name, \n" +
            "  package.date_depart, \n" +
            "  package.duration, \n" +
            "  package.description as desc, \n" +
            "  room.seats, \n" +
            "  hotel.rating, \n" +
            "  room.type as room_type, \n" +
            "  hotel.sea_distance, \n" +
            "  meal.type as meal_type, \n" +
            "  package.insurance, \n" +
            "  package.visa, \n" +
            "  package.transfer\n" +
            "FROM \n" +
            "  public.\"City\" as city, \n" +
            "  public.\"Country\" as country, \n" +
            "  public.\"Hotel\" as hotel, \n" +
            "  public.\"Meal\" as meal, \n" +
            "  public.\"Package\" as package, \n" +
            "  public.\"Room\" as room\n" +
            "WHERE \n" +
            "  city.country_id = country.id AND\n" +
            "  hotel.city_id = city.id AND\n" +
            "  meal.hotel_id = hotel.id AND\n" +
            "  package.hotel_id = hotel.id AND\n" +
            "  room.hotel_id = hotel.id AND\n" +
            "  room.id NOT IN (SELECT room_id FROM public.\"Users_Packages\") AND" +
            "  package.id = ? AND\n" +
            "  room.id = ? AND\n" +
            "  meal.id = ?;";

    public static final String SQL_GET_PACKAGE_BY_USERNAME = "SELECT \n" +
            "  package.id as package_id,\n" +
            "  room.id as room_id,\n" +
            "  meal.id as meal_id, \n" +
            "  country.name as country_name, \n" +
            "  city.name as city_name, \n" +
            "  hotel.name as hotel_name, \n" +
            "  package.date_depart, \n" +
            "  package.duration, \n" +
            "  package.description as desc, \n" +
            "  room.seats, \n" +
            "  hotel.rating, \n" +
            "  room.type as room_type, \n" +
            "  hotel.sea_distance, \n" +
            "  meal.type as meal_type, \n" +
            "  package.insurance, \n" +
            "  package.visa, \n" +
            "  package.transfer\n" +
            "FROM \n" +
            "  public.\"City\" as city, \n" +
            "  public.\"Country\" as country, \n" +
            "  public.\"Hotel\" as hotel, \n" +
            "  public.\"Meal\" as meal, \n" +
            "  public.\"Package\" as package, \n" +
            "  public.\"Room\" as room,\n" +
            "  public.\"Users_Packages\" as tour,\n" +
            "  public.\"User\" as usr\n" +
            "WHERE \n" +
            "  city.country_id = country.id AND\n" +
            "  hotel.city_id = city.id AND\n" +
            "  meal.hotel_id = hotel.id AND\n" +
            "  package.hotel_id = hotel.id AND\n" +
            "  room.hotel_id = hotel.id AND\n" +
            "  usr.tour_id = tour.id AND\n" +
            "  tour.package_id = package.id AND\n" +
            "  tour.meal_id = meal.id AND\n" +
            "  tour.room_id = room.id AND\n" +
            "  usr.username = ?;";

    public static final String SQL_SET_USERS_PACKAGES = "INSERT INTO public.\"Users_Packages\"(package_id, room_id, meal_id) " +
            "  VALUES(?,?,?);";

    public static final String SQL_GET_USERS_PACKAGE_ID = "SELECT id FROM public.\"Users_Packages\" " +
            "WHERE package_id = ? AND room_id = ? AND meal_id = ?;";

    public static final String SQL_REMOVE_USERS_PACKAGE = "DELETE FROM public.\"Users_Packages\" WHERE id = ?;";
    public static final String SQL_GET_USER_PACKAGE_ID_BY_USERNAME = "SELECT usP.id FROM public.\"Users_Packages\" as usP, public.\"User\" as usr " +
            "WHERE usr.tour_id = usP.id AND usr.username = ?;";
}

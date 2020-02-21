package com.tgdevelopment.databases.oracle

class OracleQueries {

    public static String GET_OBJECTS_WITH_TYPES =
    """
    select name, type, LISTAGG(text, chr(13)) WITHIN GROUP (ORDER BY name, type, line) AS text
    from user_source us
    where us.type in (?types)
    group by name, type
    order by name, type
    """

}

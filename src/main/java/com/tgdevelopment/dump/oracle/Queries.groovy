package com.tgdevelopment.dump.oracle

import static ObjectTypes.createSqlFilter

class Queries {

    public static String GET_OBJECTS =
    """
    select name, type, LISTAGG(text, chr(13)) WITHIN GROUP (ORDER BY name, type, line) AS text
    from user_source us
    where us.type in ()
    group by name, type
    order by name, type
    """

}

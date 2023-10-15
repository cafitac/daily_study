package com.example.fastcampusmysql.util;

import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.FieldPredicates.ofType;

import com.example.fastcampusmysql.domain.member.entity.Member;
import java.util.Random;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {

    private static final Random random = new Random();

    public static EasyRandom get() {
        var idPredicate = named("id")
            .and(ofType(Long.class))
            .and(inClass(Member.class));

        var param = new EasyRandomParameters()
            .excludeField(idPredicate)
            .stringLengthRange(5, 10);

        return new EasyRandom(param);
    }

    public static EasyRandom getBySeed() {
        var idPredicate = named("id")
            .and(ofType(Long.class))
            .and(inClass(Member.class));

        var param = new EasyRandomParameters()
            .seed(random.nextLong())
            .excludeField(idPredicate)
            .stringLengthRange(5, 10);

        return new EasyRandom(param);
    }
}

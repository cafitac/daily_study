package com.example.fastcampusmysql.util;

import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.FieldPredicates.ofType;

import com.example.fastcampusmysql.domain.post.entity.PostLike;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class PostLikeFixtureFactory {

    public static EasyRandom get(Long postId) {
        var idPredicate = named("id")
            .and(ofType(Long.class))
            .and(inClass(PostLike.class));

        var memberIdPredicate = named("memberId")
            .and(ofType(Long.class))
            .and(inClass(PostLike.class));

        var postIdPredicate = named("postId")
            .and(ofType(Long.class))
            .and(inClass(PostLike.class));

        var param = new EasyRandomParameters()
            .excludeField(idPredicate)
            .randomize(postIdPredicate, () -> postId);

        return new EasyRandom(param);
    }
}

package com.sgic.myleave.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLeaveRequest is a Querydsl query type for LeaveRequest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLeaveRequest extends EntityPathBase<LeaveRequest> {

    private static final long serialVersionUID = 195044749L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLeaveRequest leaveRequest = new QLeaveRequest("leaveRequest");

    public final DateTimePath<java.time.ZonedDateTime> fromTime = createDateTime("fromTime", java.time.ZonedDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLeave leave;

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.time.ZonedDateTime> toTime = createDateTime("toTime", java.time.ZonedDateTime.class);

    public final QUser user;

    public QLeaveRequest(String variable) {
        this(LeaveRequest.class, forVariable(variable), INITS);
    }

    public QLeaveRequest(Path<? extends LeaveRequest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLeaveRequest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLeaveRequest(PathMetadata metadata, PathInits inits) {
        this(LeaveRequest.class, metadata, inits);
    }

    public QLeaveRequest(Class<? extends LeaveRequest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.leave = inits.isInitialized("leave") ? new QLeave(forProperty("leave")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}


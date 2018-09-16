package com.sgic.myleave.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLeave is a Querydsl query type for Leave
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLeave extends EntityPathBase<Leave> {

    private static final long serialVersionUID = -86603102L;

    public static final QLeave leave = new QLeave("leave");

    public final NumberPath<Integer> allocation = createNumber("allocation", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath leaveName = createString("leaveName");

    public final ListPath<LeaveRequest, QLeaveRequest> leaveRequest = this.<LeaveRequest, QLeaveRequest>createList("leaveRequest", LeaveRequest.class, QLeaveRequest.class, PathInits.DIRECT2);

    public QLeave(String variable) {
        super(Leave.class, forVariable(variable));
    }

    public QLeave(Path<? extends Leave> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLeave(PathMetadata metadata) {
        super(Leave.class, metadata);
    }

}


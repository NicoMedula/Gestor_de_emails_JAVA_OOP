package com.example.email;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Definición del servicio
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: email_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EmailServiceGrpc {

  private EmailServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "email.EmailService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.email.EmailRequest,
      com.example.email.EmailResponse> getSendEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendEmail",
      requestType = com.example.email.EmailRequest.class,
      responseType = com.example.email.EmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.email.EmailRequest,
      com.example.email.EmailResponse> getSendEmailMethod() {
    io.grpc.MethodDescriptor<com.example.email.EmailRequest, com.example.email.EmailResponse> getSendEmailMethod;
    if ((getSendEmailMethod = EmailServiceGrpc.getSendEmailMethod) == null) {
      synchronized (EmailServiceGrpc.class) {
        if ((getSendEmailMethod = EmailServiceGrpc.getSendEmailMethod) == null) {
          EmailServiceGrpc.getSendEmailMethod = getSendEmailMethod =
              io.grpc.MethodDescriptor.<com.example.email.EmailRequest, com.example.email.EmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.email.EmailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.email.EmailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EmailServiceMethodDescriptorSupplier("SendEmail"))
              .build();
        }
      }
    }
    return getSendEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.email.GetEmailsRequest,
      com.example.email.EmailResponse> getGetEmailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEmails",
      requestType = com.example.email.GetEmailsRequest.class,
      responseType = com.example.email.EmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.email.GetEmailsRequest,
      com.example.email.EmailResponse> getGetEmailsMethod() {
    io.grpc.MethodDescriptor<com.example.email.GetEmailsRequest, com.example.email.EmailResponse> getGetEmailsMethod;
    if ((getGetEmailsMethod = EmailServiceGrpc.getGetEmailsMethod) == null) {
      synchronized (EmailServiceGrpc.class) {
        if ((getGetEmailsMethod = EmailServiceGrpc.getGetEmailsMethod) == null) {
          EmailServiceGrpc.getGetEmailsMethod = getGetEmailsMethod =
              io.grpc.MethodDescriptor.<com.example.email.GetEmailsRequest, com.example.email.EmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEmails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.email.GetEmailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.email.EmailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EmailServiceMethodDescriptorSupplier("GetEmails"))
              .build();
        }
      }
    }
    return getGetEmailsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmailServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmailServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmailServiceStub>() {
        @java.lang.Override
        public EmailServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmailServiceStub(channel, callOptions);
        }
      };
    return EmailServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmailServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmailServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmailServiceBlockingStub>() {
        @java.lang.Override
        public EmailServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmailServiceBlockingStub(channel, callOptions);
        }
      };
    return EmailServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmailServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmailServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmailServiceFutureStub>() {
        @java.lang.Override
        public EmailServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmailServiceFutureStub(channel, callOptions);
        }
      };
    return EmailServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Definición del servicio
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void sendEmail(com.example.email.EmailRequest request,
        io.grpc.stub.StreamObserver<com.example.email.EmailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendEmailMethod(), responseObserver);
    }

    /**
     */
    default void getEmails(com.example.email.GetEmailsRequest request,
        io.grpc.stub.StreamObserver<com.example.email.EmailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEmailsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EmailService.
   * <pre>
   * Definición del servicio
   * </pre>
   */
  public static abstract class EmailServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EmailServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EmailService.
   * <pre>
   * Definición del servicio
   * </pre>
   */
  public static final class EmailServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EmailServiceStub> {
    private EmailServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmailServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendEmail(com.example.email.EmailRequest request,
        io.grpc.stub.StreamObserver<com.example.email.EmailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmails(com.example.email.GetEmailsRequest request,
        io.grpc.stub.StreamObserver<com.example.email.EmailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetEmailsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EmailService.
   * <pre>
   * Definición del servicio
   * </pre>
   */
  public static final class EmailServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EmailServiceBlockingStub> {
    private EmailServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmailServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.email.EmailResponse sendEmail(com.example.email.EmailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.email.EmailResponse> getEmails(
        com.example.email.GetEmailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetEmailsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EmailService.
   * <pre>
   * Definición del servicio
   * </pre>
   */
  public static final class EmailServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EmailServiceFutureStub> {
    private EmailServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmailServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.email.EmailResponse> sendEmail(
        com.example.email.EmailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendEmailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_EMAIL = 0;
  private static final int METHODID_GET_EMAILS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_EMAIL:
          serviceImpl.sendEmail((com.example.email.EmailRequest) request,
              (io.grpc.stub.StreamObserver<com.example.email.EmailResponse>) responseObserver);
          break;
        case METHODID_GET_EMAILS:
          serviceImpl.getEmails((com.example.email.GetEmailsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.email.EmailResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendEmailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.email.EmailRequest,
              com.example.email.EmailResponse>(
                service, METHODID_SEND_EMAIL)))
        .addMethod(
          getGetEmailsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.email.GetEmailsRequest,
              com.example.email.EmailResponse>(
                service, METHODID_GET_EMAILS)))
        .build();
  }

  private static abstract class EmailServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmailServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.email.EmailServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmailService");
    }
  }

  private static final class EmailServiceFileDescriptorSupplier
      extends EmailServiceBaseDescriptorSupplier {
    EmailServiceFileDescriptorSupplier() {}
  }

  private static final class EmailServiceMethodDescriptorSupplier
      extends EmailServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EmailServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmailServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmailServiceFileDescriptorSupplier())
              .addMethod(getSendEmailMethod())
              .addMethod(getGetEmailsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app/echo.proto

package app.grpc.server.gen.echo;

public final class EchoServiceProto {
  private EchoServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_EchoMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_messages_EchoMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016app/echo.proto\022\010messages\"\036\n\013EchoMessag" +
      "e\022\017\n\007message\030\001 \001(\t2L\n\013EchoService\022=\n\013Ech" +
      "oService\022\025.messages.EchoMessage\032\025.messag" +
      "es.EchoMessage\"\000B4\n\030app.grpc.server.gen." +
      "echoB\020EchoServiceProtoP\001Z\004echob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_messages_EchoMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_EchoMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_messages_EchoMessage_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

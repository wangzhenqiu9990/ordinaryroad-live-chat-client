/*
 * MIT License
 *
 * Copyright (c) 2023 OrdinaryRoad
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WebLiveAssistantType.proto

package tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf;

public final class WebLiveAssistantTypeOuterClass {
  private WebLiveAssistantTypeOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code WebLiveAssistantType}
   */
  public enum WebLiveAssistantType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>UNKNOWN_ASSISTANT_TYPE = 0;</code>
     */
    UNKNOWN_ASSISTANT_TYPE(0),
    /**
     * <code>SUPER = 1;</code>
     */
    SUPER(1),
    /**
     * <code>JUNIOR = 2;</code>
     */
    JUNIOR(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>UNKNOWN_ASSISTANT_TYPE = 0;</code>
     */
    public static final int UNKNOWN_ASSISTANT_TYPE_VALUE = 0;
    /**
     * <code>SUPER = 1;</code>
     */
    public static final int SUPER_VALUE = 1;
    /**
     * <code>JUNIOR = 2;</code>
     */
    public static final int JUNIOR_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static WebLiveAssistantType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static WebLiveAssistantType forNumber(int value) {
      switch (value) {
        case 0: return UNKNOWN_ASSISTANT_TYPE;
        case 1: return SUPER;
        case 2: return JUNIOR;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<WebLiveAssistantType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        WebLiveAssistantType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<WebLiveAssistantType>() {
            public WebLiveAssistantType findValueByNumber(int number) {
              return WebLiveAssistantType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return WebLiveAssistantTypeOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final WebLiveAssistantType[] VALUES = values();

    public static WebLiveAssistantType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private WebLiveAssistantType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:WebLiveAssistantType)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032WebLiveAssistantType.proto*I\n\024WebLiveA" +
      "ssistantType\022\032\n\026UNKNOWN_ASSISTANT_TYPE\020\000" +
      "\022\t\n\005SUPER\020\001\022\n\n\006JUNIOR\020\002B6\n4tech.ordinary" +
      "road.live.chat.client.kuaishou.protobufb" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
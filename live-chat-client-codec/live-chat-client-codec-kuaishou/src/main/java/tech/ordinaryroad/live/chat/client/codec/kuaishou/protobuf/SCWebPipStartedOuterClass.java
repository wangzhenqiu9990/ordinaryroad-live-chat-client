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
// source: SCWebPipStarted.proto

package tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf;

public final class SCWebPipStartedOuterClass {
  private SCWebPipStartedOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SCWebPipStartedOrBuilder extends
      // @@protoc_insertion_point(interface_extends:SCWebPipStarted)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 time = 1;</code>
     * @return The time.
     */
    long getTime();
  }
  /**
   * Protobuf type {@code SCWebPipStarted}
   */
  public static final class SCWebPipStarted extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:SCWebPipStarted)
      SCWebPipStartedOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use SCWebPipStarted.newBuilder() to construct.
    private SCWebPipStarted(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SCWebPipStarted() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new SCWebPipStarted();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return SCWebPipStartedOuterClass.internal_static_SCWebPipStarted_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return SCWebPipStartedOuterClass.internal_static_SCWebPipStarted_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SCWebPipStartedOuterClass.SCWebPipStarted.class, SCWebPipStartedOuterClass.SCWebPipStarted.Builder.class);
    }

    public static final int TIME_FIELD_NUMBER = 1;
    private long time_ = 0L;
    /**
     * <code>uint64 time = 1;</code>
     * @return The time.
     */
    @java.lang.Override
    public long getTime() {
      return time_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (time_ != 0L) {
        output.writeUInt64(1, time_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (time_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, time_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof SCWebPipStartedOuterClass.SCWebPipStarted)) {
        return super.equals(obj);
      }
      SCWebPipStartedOuterClass.SCWebPipStarted other = (SCWebPipStartedOuterClass.SCWebPipStarted) obj;

      if (getTime()
          != other.getTime()) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TIME_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTime());
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static SCWebPipStartedOuterClass.SCWebPipStarted parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static SCWebPipStartedOuterClass.SCWebPipStarted parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SCWebPipStartedOuterClass.SCWebPipStarted parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(SCWebPipStartedOuterClass.SCWebPipStarted prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code SCWebPipStarted}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:SCWebPipStarted)
        SCWebPipStartedOuterClass.SCWebPipStartedOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return SCWebPipStartedOuterClass.internal_static_SCWebPipStarted_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return SCWebPipStartedOuterClass.internal_static_SCWebPipStarted_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                SCWebPipStartedOuterClass.SCWebPipStarted.class, SCWebPipStartedOuterClass.SCWebPipStarted.Builder.class);
      }

      // Construct using tech.ordinaryroad.live.chat.client.kuaishou.protobuf.SCWebPipStartedOuterClass.SCWebPipStarted.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        time_ = 0L;
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return SCWebPipStartedOuterClass.internal_static_SCWebPipStarted_descriptor;
      }

      @java.lang.Override
      public SCWebPipStartedOuterClass.SCWebPipStarted getDefaultInstanceForType() {
        return SCWebPipStartedOuterClass.SCWebPipStarted.getDefaultInstance();
      }

      @java.lang.Override
      public SCWebPipStartedOuterClass.SCWebPipStarted build() {
        SCWebPipStartedOuterClass.SCWebPipStarted result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public SCWebPipStartedOuterClass.SCWebPipStarted buildPartial() {
        SCWebPipStartedOuterClass.SCWebPipStarted result = new SCWebPipStartedOuterClass.SCWebPipStarted(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(SCWebPipStartedOuterClass.SCWebPipStarted result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.time_ = time_;
        }
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof SCWebPipStartedOuterClass.SCWebPipStarted) {
          return mergeFrom((SCWebPipStartedOuterClass.SCWebPipStarted)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(SCWebPipStartedOuterClass.SCWebPipStarted other) {
        if (other == SCWebPipStartedOuterClass.SCWebPipStarted.getDefaultInstance()) return this;
        if (other.getTime() != 0L) {
          setTime(other.getTime());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 8: {
                time_ = input.readUInt64();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private long time_ ;
      /**
       * <code>uint64 time = 1;</code>
       * @return The time.
       */
      @java.lang.Override
      public long getTime() {
        return time_;
      }
      /**
       * <code>uint64 time = 1;</code>
       * @param value The time to set.
       * @return This builder for chaining.
       */
      public Builder setTime(long value) {

        time_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>uint64 time = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearTime() {
        bitField0_ = (bitField0_ & ~0x00000001);
        time_ = 0L;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:SCWebPipStarted)
    }

    // @@protoc_insertion_point(class_scope:SCWebPipStarted)
    private static final SCWebPipStartedOuterClass.SCWebPipStarted DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new SCWebPipStartedOuterClass.SCWebPipStarted();
    }

    public static SCWebPipStartedOuterClass.SCWebPipStarted getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SCWebPipStarted>
        PARSER = new com.google.protobuf.AbstractParser<SCWebPipStarted>() {
      @java.lang.Override
      public SCWebPipStarted parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<SCWebPipStarted> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SCWebPipStarted> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public SCWebPipStartedOuterClass.SCWebPipStarted getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SCWebPipStarted_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SCWebPipStarted_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025SCWebPipStarted.proto\"\037\n\017SCWebPipStart" +
      "ed\022\014\n\004time\030\001 \001(\004B6\n4tech.ordinaryroad.li" +
      "ve.chat.client.kuaishou.protobufb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_SCWebPipStarted_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SCWebPipStarted_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SCWebPipStarted_descriptor,
        new java.lang.String[] { "Time", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
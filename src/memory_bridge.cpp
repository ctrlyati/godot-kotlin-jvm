#include <core/object.h>
#include <core/reference.h>
#include "memory_bridge.h"

JNI_INIT_STATICS_FOR_CLASS(MemoryBridge)

MemoryBridge::MemoryBridge(jni::JObject p_wrapped, jni::JObject p_class_loader) :
        JavaInstanceWrapper("godot.core.GarbageCollector$MemoryBridge", p_wrapped, p_class_loader) {
    jni::JNativeMethod check_instance_method{
            "checkInstance",
            "(JJ)Z",
            (void*) MemoryBridge::check_instance
    };

    jni::JNativeMethod unref_method{
            "unref",
            "(J)Z",
            (void*) MemoryBridge::unref
    };

    jni::JNativeMethod ref_method{
            "ref",
            "(J)Z",
            (void*) MemoryBridge::ref
    };

    Vector<jni::JNativeMethod> methods;
    methods.push_back(check_instance_method);
    methods.push_back(unref_method);
    methods.push_back(ref_method);

    jni::Env env{jni::Jvm::current_env()};
    j_class.register_natives(env, methods);
    p_wrapped.delete_local_ref(env);
}

bool MemoryBridge::check_instance(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr, jlong instance_id) {
    auto* instance{reinterpret_cast<Object*>(static_cast<uintptr_t>(p_raw_ptr))};
    jni::Env env(p_raw_env);
    jni::JObject local_ref{p_instance};
    local_ref.delete_local_ref(env);
    return ObjectDB::instance_validate(instance) && instance->get_instance_id() == static_cast<ObjectID>(instance_id);
}

bool MemoryBridge::unref(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    auto* reference{reinterpret_cast<Reference*>(static_cast<uintptr_t>(p_raw_ptr))};
    jni::Env env(p_raw_env);
    jni::JObject loacl_ref{p_instance};
    loacl_ref.delete_local_ref(env);
    if (reference->unreference()) {
        memdelete(reference);
        return true;
    } else {
        print_verbose(vformat("Will not memdelete %s", static_cast<uintptr_t>(p_raw_ptr)));
        return false;
    }
}

bool MemoryBridge::ref(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr) {
    auto* reference{reinterpret_cast<Reference*>(static_cast<uintptr_t>(p_raw_ptr))};
    jni::Env env(p_raw_env);
    jni::JObject local_ref{p_instance};
    local_ref.delete_local_ref(env);
    return reference->init_ref();
}
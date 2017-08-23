#include <stdio.h>
#include <stdlib.h>
#include <jni.h>



JNIEnv* create_vm(JavaVM **jvm)
{
    JNIEnv* env;
    JavaVMInitArgs args;
    JavaVMOption options;
    args.version = JNI_VERSION_1_8;
    args.nOptions = 1;
    options.optionString = "-Djava.class.path=./";
    args.options = &options;
    args.ignoreUnrecognized = 0;
    int rv;
    rv = JNI_CreateJavaVM(jvm, (void**)&env, &args);
    if (rv < 0 || !env)
        printf("Unable to Launch JVM %d\n",rv);
    else
        printf("Launched JVM! :)\n");
    return env;
}

void invoke_class(JNIEnv* env, double* input, int n)
{
    jclass cls = (*env)->FindClass(env, "sum_Avg");
    jmethodID sum_method = (*env)->GetStaticMethodID(env, cls, "sum", "([D)D");
    jmethodID avg_method = (*env)->GetStaticMethodID(env, cls, "avg", "([D)D");
    
    jdoubleArray arr = (*env)->NewDoubleArray(env, n);
    (*env)->SetDoubleArrayRegion(env, arr, 0 , n, input);
    
    printf("Sum is %lf and average is %lf\n\n", (*env)->CallStaticDoubleMethod(env, cls, sum_method, arr), (*env)->CallStaticDoubleMethod(env, cls, avg_method, arr));
}

int main(int argc, char **argv)
{
    JavaVM *jvm;
    JNIEnv *env;
    env = create_vm(&jvm);
    if(env == NULL)
        return 1;
    int n;
    printf("Enter array size : ");
    scanf("%d",&n);
    printf("Enter array elements :");
    double *array = (double *)malloc(n*sizeof(double));
    for(int i=0; i<n; i++)
    {
    	scanf("%lf",&array[i]);
    }
    invoke_class(env, array, n);
    return 0;
}

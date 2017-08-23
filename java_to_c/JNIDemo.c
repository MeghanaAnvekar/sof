#include "/usr/lib/jvm/java-8-openjdk-amd64/include/jni.h"

JNIEXPORT jdoubleArray JNICALL Java_JNIDemo_sumAndAverage(JNIEnv *env, jobject obj, jintArray input) 
{
  
   // Step 1: Convert the incoming JNI jintarray to C's jint[]
   jint *numbers = (*env)->GetIntArrayElements(env, input, NULL);
   if (NULL == numbers) return NULL;
   jsize length = (*env)->GetArrayLength(env, input);
 
   // Step 2: Perform its intended operations
   jint sum = 0;
   int i;
   for (i = 0; i < length; i++) {
      sum += numbers[i];
   }
   jdouble average = (jdouble)sum / length;
   (*env)->ReleaseIntArrayElements(env, input, numbers, 0); // release resources
 
   jdouble result[] = {sum, average};
 
   // Step 3: Convert the C's Native jdouble[] to JNI jdoublearray, and return
   jdoubleArray outJNIArray = (*env)->NewDoubleArray(env, 2);  // allocate
   if (NULL == outJNIArray) return NULL;
   (*env)->SetDoubleArrayRegion(env, outJNIArray, 0 , 2, result);  // copy
   return outJNIArray;
}

int main()
{
	return  0;
}

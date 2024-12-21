public class RoomDependencies {
}
dependencies {
    implementation("androidx.room:room-runtime:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0") // For Kotlin use kapt instead of annotationProcessor
    implementation("androidx.room:room-ktx:2.5.0") // optional - Kotlin Extensions and Coroutines support for Room
}
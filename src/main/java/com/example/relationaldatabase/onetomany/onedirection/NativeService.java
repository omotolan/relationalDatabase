package com.example.relationaldatabase.onetomany.onedirection;

public interface NativeService {
    String addNative(AddNativeRequest addNativeRequest);

    String deleteNative(Long id);
}

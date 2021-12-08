package kr.co.e8ight.grpc_server.service;

import com.example.grpc_test.proto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        try {
            String greeting = new StringBuilder()
                    .append("Hello, ")
                    .append(request.getFirstName())
                    .append(" ")
                    .append(request.getLastName())
                    .append(" 통신에 성공했습니다~! ")
                    .toString();

            HelloResponse response = HelloResponse.newBuilder()
                    .setGreeting(greeting)
                    .build();


            responseObserver.onNext(response);
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Throwable e) {

            e.printStackTrace();
            responseObserver.onError(e);
            System.out.println("errrr");
        }
    }
}
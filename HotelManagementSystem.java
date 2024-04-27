import javax.management.relation.Role;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HotelManagementSystem extends JFrame {
    private ArrayList<Role> rooms;
    private ArrayList<Reservation> reservations;

    public HotelManagementSystem() {
        setTitle("Hotel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        JTabbedPane tabbedPane = new JTabbedPane();

        // Room Management Tab
        JPanel roomManagementPanel = new JPanel(new GridLayout(1, 2));

        JPanel roomListPanel = new JPanel(new BorderLayout());
        JList<Room> roomList = new JList<>(new DefaultListModel<>());
        roomListPanel.add(new JScrollPane(roomList), BorderLayout.CENTER);
        roomManagementPanel.add(roomListPanel);

        JPanel roomDetailsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        roomDetailsPanel.add(new JLabel("Room Number:"));
        JTextField roomNumberField = new JTextField();
        roomDetailsPanel.add(roomNumberField);
        roomDetailsPanel.add(new JLabel("Room Type:"));
        JComboBox<String> roomTypeComboBox = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        roomDetailsPanel.add(roomTypeComboBox);
        roomDetailsPanel.add(new JLabel("Availability:"));
        JCheckBox availabilityCheckBox = new JCheckBox();
        roomDetailsPanel.add(availabilityCheckBox);
        JButton saveRoomButton = new JButton("Save Room");
        roomDetailsPanel.add(saveRoomButton);
        roomManagementPanel.add(roomDetailsPanel);

        tabbedPane.addTab("Room Management", roomManagementPanel);

        // Reservation Tracking Tab
        JPanel reservationTrackingPanel = new JPanel(new GridLayout(1, 2));

        JPanel reservationListPanel = new JPanel(new BorderLayout());
        JList<Reservation> reservationList = new JList<>(new DefaultListModel<>());
        reservationListPanel.add(new JScrollPane(reservationList), BorderLayout.CENTER);
        reservationTrackingPanel.add(reservationListPanel);

        JPanel reservationDetailsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        reservationDetailsPanel.add(new JLabel("Guest Name:"));
        JTextField guestNameField = new JTextField();
        reservationDetailsPanel.add(guestNameField);
        reservationDetailsPanel.add(new JLabel("Check-in Date:"));
        JTextField checkInDateField = new JTextField();
        reservationDetailsPanel.add(checkInDateField);
        reservationDetailsPanel.add(new JLabel("Check-out Date:"));
        JTextField checkOutDateField = new JTextField();
        reservationDetailsPanel.add(checkOutDateField);
        reservationDetailsPanel.add(new JLabel("Room Number:"));
        JComboBox<Integer> roomNumberComboBox = new JComboBox<>();
        reservationDetailsPanel.add(roomNumberComboBox);
        JButton saveReservationButton = new JButton("Save Reservation");
        reservationDetailsPanel.add(saveReservationButton);
        reservationTrackingPanel.add(reservationDetailsPanel);

        tabbedPane.addTab("Reservation Tracking", reservationTrackingPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();
            hotelManagementSystem.setVisible(true);
        });
    }
}
